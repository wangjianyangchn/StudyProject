package spring.springCore.beanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//http://www.cnblogs.com/zrtqsk/p/3735273.html
//http://uule.iteye.com/blog/2094549
public class Person implements BeanNameAware, BeanFactoryAware,
		InitializingBean, DisposableBean, ApplicationContextAware {

	private String name;
	private BeanFactory beanFactory;
	private ApplicationContext applicationContext;

	public BeanFactory getBeanFactory() {
		return this.beanFactory;
	}

	public ApplicationContext getApplicationContext() {
		return this.applicationContext;
	}

	public Person() {
		System.out.println("Person.Person()");
	}

	public void beanInit() {
		System.out.println("Bean.init()");
	}

	public void destoryforXml() {
		System.out.println("Bean.destory()");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean.destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean.afterPropertiesSet()");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
		System.out.println("BeanFactoryAware.setBeanFactory()");
	}

	@Override
	public void setBeanName(String name) {
		this.name = name;
		System.out.println("BeanNameAware.setBeanName()");
	}

	public String getBeanName() {
		return this.name;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("ApplicationContextAware.setApplicationContext()");
		this.applicationContext = applicationContext;
	}
}
