/* Generated by AN DISI Unibo */ 
package it.unibo.ctxControllerTfCe16;
import it.unibo.qactors.QActorContext;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.system.SituatedSysKb;
public class MainCtxControllerTfCe16  {
  
//MAIN
public static QActorContext initTheContext() throws Exception{
	IOutputEnvView outEnvView = SituatedSysKb.standardOutEnvView;
	String webDir = null;
	return QActorContext.initQActorSystem(
		"ctxcontrollertfce16", "./srcMore/it/unibo/ctxControllerTfCe16/radar_gui.pl", 
		"./srcMore/it/unibo/ctxControllerTfCe16/sysRules.pl", outEnvView,webDir,false);
}
public static void main(String[] args) throws Exception{
	initTheContext();
} 	
}