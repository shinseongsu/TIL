package toby;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.*;

@SpringBootApplication
@Slf4j
@EnableAsync
public class TobytvApplication {

    @RestController
    public static class MyController {

        Queue<DeferredResult<String>> results = new ConcurrentLinkedQueue<>();

        @GetMapping("/emitter")
        public ResponseBodyEmitter emitter() throws InterruptedException {
            ResponseBodyEmitter emitter = new ResponseBodyEmitter();

            Executors.newSingleThreadExecutor().submit(() -> {
                try {
                    for(int i = 1; i <= 50; i++) {
                        emitter.send("<p>Stream " + i + "</p>");
                        Thread.sleep(100);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            return emitter;
        }


//        Queue<DeferredResult<String>> results = new ConcurrentLinkedQueue<>();
//
//        @GetMapping("/dr")
//        public DeferredResult<String> callable() throws InterruptedException {
//            log.info("dr");
//            DeferredResult<String> dr = new DeferredResult<>(600000L);
//            results.add(dr);
//            return dr;
//        }
//
//        @GetMapping("/dr/count")
//        public String drcount() {
//            return String.valueOf(results.size());
//        }
//
//        @GetMapping("/dr/event")
//        public String drevent(String msg) {
//            for(DeferredResult<String> dr : results) {
//                dr.setResult("Hello " + msg);
//                results.remove(dr);
//            }
//            return "OK";
//        }




//        @GetMapping("/callable")
//        public Callable<String> async() throws InterruptedException {
//            log.info("callable");
//            return () -> {
//                log.info("async");
//                Thread.sleep(2000);
//                return "hello";
//            };
//        }
//        public String callable() throws InterruptedException {
//            log.info("async");
//            Thread.sleep(2000);
//            return "hello";
//        }

    }

//    @Component
//    public static class MyService {
//        @Async
//        public ListenableFuture<String> hello() throws InterruptedException {
//            log.info("hello()");
//            Thread.sleep(2000);
//            return new AsyncResult<>("Hello");
//        }
//    }

//    @Bean
//    ThreadPoolTaskExecutor tp() {
//        ThreadPoolTaskExecutor te = new ThreadPoolTaskExecutor();
//        te.setCorePoolSize(10);
//        te.setMaxPoolSize(100);
//        te.setQueueCapacity(50);
//        te.setThreadNamePrefix("mythread");
//        te.initialize();
//
//        return te;
//    }

    public static void main(String[] args) {
        SpringApplication.run(TobytvApplication.class, args);

//        try(ConfigurableApplicationContext c = SpringApplication.run(TobytvApplication.class, args)) {
//
//        }
    }

//    @Autowired
//    MyService myService;
//
//    @Bean
//    ApplicationRunner run() {
//        return args -> {
//            log.info("run()");
//            ListenableFuture<String> f = myService.hello();
//            f.addCallback(s -> System.out.println(s), e -> System.out.println(e.getMessage()));
//            log.info("exit");
//        };
//    }

}
