%====================================================================================
% Context ctxControllerTfCe16 standalone= SYSTEM-configuration: file it.unibo.ctxControllerTfCe16.radar_gui.pl 
%====================================================================================
context(ctxcontrollertfce16, "localhost",  "TCP", "8034" ).  		 
%%% -------------------------------------------
qactor( controller , ctxcontrollertfce16, "it.unibo.controller.MsgHandle_Controller"   ). %%store msgs 
qactor( controller_ctrl , ctxcontrollertfce16, "it.unibo.controller.Controller"   ). %%control-driven 
