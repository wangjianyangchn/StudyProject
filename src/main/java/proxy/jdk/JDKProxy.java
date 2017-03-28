package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {

	private Object targetObject;

	public Object newProxy(Object targetObject) {
		this.targetObject = targetObject;
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
				targetObject.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object object = null;
		beforeMthod();
		object = method.invoke(targetObject, args);
		afterMethod();
		return object;
	}

	public void beforeMthod() {
		System.out.println("JDKProxy.beforeMthod()");
	}

	public void afterMethod() {
		System.out.println("JDKProxy.afterMethod()");
	}
}
