package proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	private Object targetObject;

	public Object newProxy(Object object) {
		this.targetObject = object;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(object.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object object, Method method, Object[] objects,
			MethodProxy methodProxy) throws Throwable {
		Object obj = null;
		beforeMethod();
		obj = method.invoke(targetObject, objects);
		afterMethod();
		return obj;
	}

	public void beforeMethod() {
		System.out.println("CglibProxy.beforeMethod()");
	}

	public void afterMethod() {
		System.out.println("CglibProxy.afterMethod()");
	}

}
