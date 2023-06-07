package estrategiaExportacion;

import java.util.*;

import modelo.FichaTecnica;

/**
 * 
 */
public interface AdapterExportarPDF {

    /**
     * @param fichaTecnica 
     * @return
     */
    public void ExportarPDF(FichaTecnica fichaTecnica);

}