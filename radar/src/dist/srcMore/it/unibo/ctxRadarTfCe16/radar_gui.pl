%====================================================================================
% Context ctxRadarTfCe16  SYSTEM-configuration: file it.unibo.ctxRadarTfCe16.radar_gui.pl 
%====================================================================================
context(ctxradartfce16, "192.168.251.1",  "TCP", "8033" ).  		 
%%% -------------------------------------------
qactor( radar_gui , ctxradartfce16, "it.unibo.radar_gui.MsgHandle_Radar_gui"   ). %%store msgs 
qactor( radar_gui_ctrl , ctxradartfce16, "it.unibo.radar_gui.Radar_gui"   ). %%control-driven 
%%% -------------------------------------------
eventhandler(evh,ctxradartfce16,"it.unibo.ctxRadarTfCe16.Evh","sonar").  
%%% -------------------------------------------

