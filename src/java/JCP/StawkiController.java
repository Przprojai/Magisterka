package JCP;

import Entity.Budynek;
import Entity.Oplaty;
import Entity.Stawki;
import JCP.util.JsfUtil;
import JCP.util.JsfUtil.PersistAction;
import SBP.StawkiFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("stawkiController")
@SessionScoped
public class StawkiController implements Serializable {

    @EJB
    private SBP.StawkiFacade ejbFacade;
    private List<Stawki> items = null;
    private Stawki selected;
    private float gaz;
    private float eksploatacja_podstawowa;
    private float fundusz_remontowy;
    private float legalizacja_wodomierza;
    private float konserwacja_domofonu;
    private float eksploatacja_dzwigow;
    private float co;
    private float cw;
    private float zwis;
    private float prad_w_pom_wspolnych;
    private float smieci;
    private float ubezpieczenie;
    private float suma;

    public StawkiFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(StawkiFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public float getEksploatacja_podstawowa() {
        return eksploatacja_podstawowa;
    }

    public void setEksploatacja_podstawowa(float eksploatacja_podstawowa) {
        this.eksploatacja_podstawowa = eksploatacja_podstawowa;
    }

    public float getFundusz_remontowy() {
        return fundusz_remontowy;
    }

    public void setFundusz_remontowy(float fundusz_remontowy) {
        this.fundusz_remontowy = fundusz_remontowy;
    }

    public float getLegalizacja_wodomierza() {
        return legalizacja_wodomierza;
    }

    public void setLegalizacja_wodomierza(float legalizacja_wodomierza) {
        this.legalizacja_wodomierza = legalizacja_wodomierza;
    }

    public float getKonserwacja_domofonu() {
        return konserwacja_domofonu;
    }

    public void setKonserwacja_domofonu(float konserwacja_domofonu) {
        this.konserwacja_domofonu = konserwacja_domofonu;
    }

    public float getEksploatacja_dzwigow() {
        return eksploatacja_dzwigow;
    }

    public void setEksploatacja_dzwigow(float eksploatacja_dzwigow) {
        this.eksploatacja_dzwigow = eksploatacja_dzwigow;
    }

    public float getCo() {
        return co;
    }

    public void setCo(float co) {
        this.co = co;
    }

    public float getCw() {
        return cw;
    }

    public void setCw(float cw) {
        this.cw = cw;
    }

    public float getZwis() {
        return zwis;
    }

    public void setZwis(float zwis) {
        this.zwis = zwis;
    }

    public float getPrad_w_pom_wspolnych() {
        return prad_w_pom_wspolnych;
    }

    public void setPrad_w_pom_wspolnych(float prad_w_pom_wspolnych) {
        this.prad_w_pom_wspolnych = prad_w_pom_wspolnych;
    }

    public float getSmieci() {
        return smieci;
    }

    public void setSmieci(float smieci) {
        this.smieci = smieci;
    }

    public float getUbezpieczenie() {
        return ubezpieczenie;
    }

    public void setUbezpieczenie(float ubezpieczenie) {
        this.ubezpieczenie = ubezpieczenie;
    }

    public float getSuma() {
        return suma;
    }

    public void setSuma(float suma) {
        this.suma = suma;
    }

    public void setGaz(float gaz) {
        this.gaz = gaz;
    }

    public float getGaz() {
        return gaz;
    }

    public StawkiController() {
    }

    public Stawki getSelected() {
        return selected;
    }

    public void setSelected(Stawki selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private StawkiFacade getFacade() {
        return ejbFacade;
    }

    public Stawki prepareCreate() {
        selected = new Stawki();
        initializeEmbeddableKey();
        return selected;
    }
    static Stawki zwroc(Budynek budynek){
        return StawkiController.zwroc(budynek);
    }
    public List<String[]> pdf(Oplaty oplaty){
        selected=oplaty.getIdStawki();
        String[] lista = new String[2];
        List<String[]> dupa = new ArrayList<>();
        lista[0]="Eksploatacja podstawowa "+ selected.getEksploatacjaPodstawowa()+"  zł/m2 * " + oplaty.getIdMieszkania().getPowierzchnia() +" m2";
        lista[1]=""+selected.getEksploatacjaPodstawowa();
        dupa.add(lista);
        lista[0]="asd";
        lista[1]="dupa";
        dupa.add(lista);
                lista[0]="asd";
        lista[1]="dupa";
        dupa.add(lista);
                lista[0]="asd";
        lista[1]="dupa";
        dupa.add(lista);
                lista[0]="asd";
        lista[1]="dupa";
        dupa.add(lista);
        return dupa;
    }
    public void szczegoly(Oplaty oplaty){
      selected=oplaty.getIdStawki();
      eksploatacja_podstawowa=(float)(((int)(100*selected.getEksploatacjaPodstawowa()*oplaty.getIdMieszkania().getPowierzchnia()))*0.01);
      fundusz_remontowy=(float)(((int)(100*selected.getFunduszRemontowy()*oplaty.getIdMieszkania().getPowierzchnia()))*0.01);
      legalizacja_wodomierza=(float)(((int)(100*selected.getLegalizacjaWodomierza()*2))*0.01);
      konserwacja_domofonu=(float)(((int)(100*selected.getKonserwacjaDomofonu()))*0.01);
      eksploatacja_dzwigow=(float)(((int)(100*selected.getEksploatacjaDzwigow()*oplaty.getIdMieszkania().getLiczbaOsob()*oplaty.getIdMieszkania().getPietro()))*0.01);
      co=(float)(((int)(100*selected.getCo()*oplaty.getIdMieszkania().getLicznikCiepla()))*0.01);
      cw=(float)(((int)(100*selected.getCw()*oplaty.getIdMieszkania().getLicznikWodyCieplej()))*0.01);
      zwis=(float)(((int)(100*selected.getZwis()*oplaty.getIdMieszkania().getLicznikWodyZimnej()))*0.01);
      prad_w_pom_wspolnych=(float)(((int)(100*selected.getPradWPomWspolnych()*oplaty.getIdMieszkania().getLiczbaOsob()))*0.01);
      smieci=(float)(((int)(100*selected.getSmieci()))*0.01);
      ubezpieczenie=(float)(((int)(100*selected.getUbezpieczenie()))*0.01);
      gaz=(float)(((int)(100*selected.getGaz()*oplaty.getIdMieszkania().getLiczbaOsob()))*0.01);
      suma=(float)(((int)(100*(eksploatacja_podstawowa+fundusz_remontowy+legalizacja_wodomierza+konserwacja_domofonu+eksploatacja_dzwigow+co+cw+zwis+gaz+prad_w_pom_wspolnych+smieci+ubezpieczenie)))*0.01);

    }
    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("StawkiCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("StawkiUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("StawkiDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Stawki> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Stawki getStawki(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Stawki> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Stawki> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Stawki.class)
    public static class StawkiControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            StawkiController controller = (StawkiController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "stawkiController");
            return controller.getStawki(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Stawki) {
                Stawki o = (Stawki) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Stawki.class.getName()});
                return null;
            }
        }

    }

}
