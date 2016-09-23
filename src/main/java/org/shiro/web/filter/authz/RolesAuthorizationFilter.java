package org.shiro.web.filter.authz;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

/**
 * 重写isAccessAllowed方法，
 * 在shiro中，role["",""]标签表示and关系，
 * 既要满足两个角色才可以，
 * 现在修改为or，只要满足其中一个角色即可。
 * @author xiaoyu
 *
 */
public class RolesAuthorizationFilter extends AuthorizationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object obj) throws Exception {
		Subject subject = getSubject(request, response);   
        String[] rolesArray = (String[]) obj;   
  
        if (rolesArray == null || rolesArray.length == 0) {   
            //no roles specified, so nothing to check - allow access.   
            return true;   
        }   
  
        for(int i=0;i<rolesArray.length;i++){    
            if(subject.hasRole(rolesArray[i])){    
                return true;    
            }    
        }    
        return false;    
	}

}
