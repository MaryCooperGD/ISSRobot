%====================================================================================
% Context ctxRadarTfCe16  SYSTEM-configuration: file it.unibo.ctxRadarTfCe16.radar_gui.pl 
%====================================================================================
context(ctxradartfce16, "localhost",  "TCP", "8033" ).  		 
context(ctxcontrollertfce16, "localhost",  "TCP", "8034" ).  		 
%%% -------------------------------------------
qactor( radar_gui , ctxradartfce16, "it.unibo.radar_gui.MsgHandle_Radar_gui"   ). %%store msgs 
qactor( radar_gui_ctrl , ctxradartfce16, "it.unibo.radar_gui.Radar_gui"   ). %%control-driven 
qactor( controller , ctxcontrollertfce16, "it.unibo.controller.MsgHandle_Controller"   ). %%store msgs 
qactor( controller_ctrl , ctxcontrollertfce16, "it.unibo.controller.Controller"   ). %%control-driven 
%%% -------------------------------------------
eventhandler(evh,ctxradartfce16,"it.unibo.ctxRadarTfCe16.Evh","sonar").  
%%% -------------------------------------------

