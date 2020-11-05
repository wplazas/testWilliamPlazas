package controller;

import entities.Recorte;
import facade.RecorteFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "recorteController")
@ViewScoped
public class RecorteController extends AbstractController<Recorte> {

    @Inject
    private DocumentoController iddocumentoController;
    @Inject
    private MobilePageController mobilePageController;

    public RecorteController() {
        // Inform the Abstract parent controller of the concrete Recorte Entity
        super(Recorte.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        iddocumentoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Documento controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIddocumento(ActionEvent event) {
        Recorte selected = this.getSelected();
        if (selected != null && iddocumentoController.getSelected() == null) {
            iddocumentoController.setSelected(selected.getIddocumento());
        }
    }

}
