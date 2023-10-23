package br.com.will.interceptor;

import br.com.will.annotation.LogMe;
import io.quarkus.logging.Log;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@LogMe
@Interceptor
@Priority(1)
public class LoggerInterceptor {

    /**
     * Irá loggar o nome da classe e método que está sendo executado
     * 
     */
    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        Log.infov("----> Executando a classe: {0}, método: {1}",
                context.getMethod().getDeclaringClass().getSimpleName(), context.getMethod().getName());

        return context.proceed();
    }

}
