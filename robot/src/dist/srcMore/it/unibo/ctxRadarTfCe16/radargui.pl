%====================================================================================
% Context ctxRadarTfCe16 standalone= SYSTEM-configuration: file it.unibo.ctxRadarTfCe16.radargui.pl 
%====================================================================================
context(ctxradartfce16, "192.168.251.1",  "TCP", "8033" ).  		 
%%% -------------------------------------------
qactor( radargui , ctxradartfce16, "it.unibo.radargui.MsgHandle_Radargui"   ). %%store msgs 
qactor( radargui_ctrl , ctxradartfce16, "it.unibo.radargui.Radargui"   ). %%control-driven 
