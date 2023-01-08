package com.example.grpcapplication.resources;

import com.example.grpcapplication.HelloReq;
import com.example.grpcapplication.HelloRes;
import com.example.grpcapplication.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloResource extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloReq request, StreamObserver<HelloRes> responseObserver) {
        var response = HelloRes.newBuilder()
                .setMessage(request.getMessage())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
