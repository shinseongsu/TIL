package com.example.payment.config

import io.micrometer.context.ContextRegistry
import mu.KotlinLogging
import org.slf4j.MDC
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Hooks
import reactor.core.publisher.Mono
import reactor.util.context.Context
import java.util.UUID

const val KEY_TXID = "txid"

private val logger = KotlinLogging.logger {}

@Component
@Order(1)
class MdcFilter: WebFilter {
    init {
        propagateMdcThroughReactor()
    }

    private fun propagateMdcThroughReactor() {
        Hooks.enableAutomaticContextPropagation()
        ContextRegistry.getInstance().registerThreadLocalAccessor(
            KEY_TXID,
            { MDC.get(KEY_TXID) },
            { value -> MDC.put(KEY_TXID, value) },
            { MDC.remove(KEY_TXID) }
        )
    }

    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val uuid = exchange.request.headers["x-txid"]?.firstOrNull() ?: "${UUID.randomUUID()}"
        MDC.put(KEY_TXID, uuid)
        return chain.filter(exchange).contextWrite {
            Context.of(KEY_TXID, uuid)
        }.doOnError {
            exchange.request.txid = uuid
        }
    }

}
