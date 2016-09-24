package org.shiro.bean;

import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.springframework.beans.factory.FactoryBean;

public class DynamicUrls implements FactoryBean<Ini.Section> {

	//在项目启动的时候，加载配置文件上的 约束配置
	private String filterChainDefinitions;
	
	/**
	 * 在这里我们可以从数据库中获取相关权限，再存放进section中
	 */
	@Override
	public Section getObject() throws Exception {
		Ini ini = new Ini();
		ini.load(filterChainDefinitions);
		Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
		// alibaba的druid监控器 
		// /druid/**=anyRoles["admin"]
		// /**=kickout,authc
		section.put("/druid/**", "anyRoles[admin]");
		section.put("/**", "kickout,authc");
		return section;
	}

	@Override
	public Class<?> getObjectType() {
		return Section.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
	
	public void setFilterChainDefinitions(String filterChainDefinitions) {
		this.filterChainDefinitions = filterChainDefinitions;
	}
	
}
