package estrategiaExportacion;

import java.util.*;

import modelo.FichaTecnica;

/**
 * 
 */
public interface AdapterExportarExcel {

    /**
     * @param fichaTecnica 
     * @return
     */
    public void ExportarExcel(FichaTecnica fichaTecnica);

}