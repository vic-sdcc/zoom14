/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import model.CoopKey;
import model.CoopMaterialKey;
import service.CoopKeyFacadeREST;
import service.CoopMaterialKeyFacadeREST;

/**
 *
 * @author mis
 */
@ManagedBean
@SessionScoped
public class TagBean {

    @PersistenceUnit
    EntityManagerFactory emf;

    @EJB
    private CoopKeyFacadeREST coopKeyFacadeREST;
    private CoopKey key = new CoopKey();
    private List<CoopKey> keyList;
    private DataModel<CoopKey> keyMatModel;
    private CoopKey selectedKey;

    @EJB
    private CoopMaterialKeyFacadeREST coopMaterialKeyFacadeREST;
    private CoopMaterialKey matKey = new CoopMaterialKey();

    private ArrayList<MoreBean> tagBox = new ArrayList<>();
    private String tagIn;

    public void init() {
        keyList = coopKeyFacadeREST.findAll();

    }

    public void beanclear() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("tagBean", null);
    }

    /**
     * Creates a new instance of TagBean
     */
    public TagBean() {
        key = new CoopKey();
        getTagBox().add(new MoreBean(getTagIn()));
        //tagBox.add(new TagBean());
    }

    public CoopKeyFacadeREST getCoopKeyFacadeREST() {
        return coopKeyFacadeREST;
    }

    public void setCoopKeyFacadeREST(CoopKeyFacadeREST coopKeyFacadeREST) {
        this.coopKeyFacadeREST = coopKeyFacadeREST;
    }

    public CoopKey getKey() {
        return key;
    }

    public void setKey(CoopKey key) {
        this.key = key;
    }

    public List<CoopKey> getKeyList() {
        return keyList;
    }

    public void setKeyList(List<CoopKey> keyList) {
        this.keyList = keyList;
    }

    public DataModel<CoopKey> getKeyMatModel() {
        return keyMatModel;
    }

    public void setKeyMatModel(DataModel<CoopKey> keyMatModel) {
        this.keyMatModel = keyMatModel;
    }

    public CoopKey getSelectedKey() {
        return selectedKey;
    }

    public void setSelectedKey(CoopKey selectedKey) {
        this.selectedKey = selectedKey;
    }

    public CoopMaterialKeyFacadeREST getCoopMaterialKeyFacadeREST() {
        return coopMaterialKeyFacadeREST;
    }

    public void setCoopMaterialKeyFacadeREST(CoopMaterialKeyFacadeREST coopMaterialKeyFacadeREST) {
        this.coopMaterialKeyFacadeREST = coopMaterialKeyFacadeREST;
    }

    public CoopMaterialKey getMatKey() {
        return matKey;
    }

    public void setMatKey(CoopMaterialKey matKey) {
        this.matKey = matKey;
    }

    public ArrayList<MoreBean> getTagBox() {
        return tagBox;
    }

    public void setTagBox(ArrayList<MoreBean> tagBox) {
        this.tagBox = tagBox;
    }

    public String getTagIn() {
        //tagIn=getTagIn().getTitle();
        return tagIn;
    }

    public void setTagIn(String tagIn) {
        this.tagIn = tagIn;
    }

    public void addTagBox() {
        if (getTagBox().size() <= 9) {
            getTagBox().add(new MoreBean(getTagIn()));
        }
    }

    public void remTagBox() {
        if (getTagBox().size() > 1) {
            getTagBox().remove(getTagBox().size() - 1);
        }
    }

    public String save() {

        for (int i = 0; i != tagBox.size(); i++) {
            key.setKeyTag(tagBox.get(i).getTagIn());
            coopKeyFacadeREST.create(key);
        }

        key = new CoopKey();
        beanclear();
        return "addTag.xhtml";
    }

}
