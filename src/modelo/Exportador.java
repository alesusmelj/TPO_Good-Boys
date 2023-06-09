package modelo;

import estrategiaExportacion.IExportar;

public class Exportador {
    private IExportar estrategiaExport;
    
    public void exportar(FichaTecnica fichaTecnica) {
    	this.estrategiaExport.Exportar(fichaTecnica);
    }
    
    public void cambiarEstrategia(IExportar estrategiaExport) {
    	this.estrategiaExport = estrategiaExport;
    }
}
