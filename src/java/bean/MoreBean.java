/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author mis
 */
@ManagedBean
@SessionScoped
public class MoreBean {
	private String tagIn;
	/**
	 * Creates a new instance of MoreBean
	 */
	public MoreBean() {
	}
	
	public MoreBean(String tagIn) {
		this.tagIn=tagIn;
	}

	public String getTagIn() {
		return tagIn;
	}

	public void setTagIn(String tagIn) {
		this.tagIn = tagIn;
	}
	
}
