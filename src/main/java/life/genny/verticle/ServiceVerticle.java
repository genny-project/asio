package life.genny.verticle;

import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.core.Future;
import life.genny.cluster.Cluster;
import life.genny.cluster.CurrentVtxCtx;


public class ServiceVerticle extends AbstractVerticle {
	 @Override
	  public void start() {
	    final Future<Void> startFuture = Future.future();
	    Cluster.joinCluster().compose(res -> {
	      final Future<Void> fut = Future.future();
	        CurrentVtxCtx.getCurrentCtx().getClusterVtx().eventBus().addInterceptor( message -> {
	            System.out.println("LOG: " + message.message().body().toString());
	      });
	        
	        fut.complete();
	      }, startFuture);
	  }
}
