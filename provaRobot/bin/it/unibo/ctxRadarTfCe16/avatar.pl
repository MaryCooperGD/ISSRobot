%====================================================================================
% Context ctxRadarTfCe16 standalone= SYSTEM-configuration: file it.unibo.ctxRadarTfCe16.avatar.pl 
%====================================================================================
context(ctxradartfce16, "192.168.1.103",  "TCP", "8033" ).  		 
%%% -------------------------------------------
qactor( radar_gui , ctxradartfce16, "it.unibo.radar_gui.MsgHandle_Radar_gui"   ). %%store msgs 
qactor( radar_gui_ctrl , ctxradartfce16, "it.unibo.radar_gui.Radar_gui"   ). %%control-driven 
