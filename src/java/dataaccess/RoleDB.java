package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import models.Role;


public class RoleDB {
    
    public List<Role> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try{
            List<Role> roles = em.createNamedQuery("Role.findAll", Role.class).getResultList();
            return roles;
        }finally{
            em.close();
        }
    }
    
    public Role get(int roleId) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try{
            Role role = em.find(Role.class, roleId);
            return role;
        }finally{
            em.close();
        }
    }
    
    public Role get(String roleName) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try{
            List<Role> roles = em.createNamedQuery("Role.findAll", Role.class).getResultList();
            
            Role role = null;
            
            for (Role roleFind:roles){
                if(roleFind.getRoleName().equals(roleName)){
                    role = roleFind;
                }
            }
            
            return role;
        }finally{
            em.close();
        }
    }
    
}
