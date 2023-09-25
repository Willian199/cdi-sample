package interceptor;

import br.com.will.annotation.LogMe;
import io.quarkus.logging.Log;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@LogMe
@Interceptor
public class LoggerInterceptor {

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        Log.infov("----> Executando a classe: {0}, método: {1}", context.getClass().getSimpleName(), context.getMethod().getName());

        return context.proceed();
    }

}
