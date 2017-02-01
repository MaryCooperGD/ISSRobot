%====================================================================================
% Context ctxControllerTfCe16  SYSTEM-configuration: file it.unibo.ctxControllerTfCe16.avatar.pl 
%====================================================================================
context(ctxrobot, "192.168.137.2",  "TCP", "8070" ).  		 
context(ctxradartfce16, "192.168.1.103",  "TCP", "8033" ).  		 
context(ctxcontrollertfce16, "192.168.1.103",  "TCP", "7034" ).  		 
context(ctxsensoremitter, "192.168.1.103",  "TCP", "8133" ).  		 
%%% -------------------------------------------
qactor( radar_gui , ctxradartfce16, "it.unibo.radar_gui.MsgHandle_Radar_gui"   ). %%store msgs 
qactor( radar_gui_ctrl , ctxradartfce16, "it.unibo.radar_gui.Radar_gui"   ). %%control-driven 
qactor( controller , ctxcontrollertfce16, "it.unibo.controller.MsgHandle_Controller"   ). %%store msgs 
qactor( controller_ctrl , ctxcontrollertfce16, "it.unibo.controller.Controller"   ). %%control-driven 
qactor( sensorsonar , ctxsensoremitter, "it.unibo.sensorsonar.MsgHandle_Sensorsonar"   ). %%store msgs 
qactor( sensorsonar_ctrl , ctxsensoremitter, "it.unibo.sensorsonar.Sensorsonar"   ). %%control-driven 
%%% -------------------------------------------
eventhandler(evh,ctxcontrollertfce16,"it.unibo.ctxControllerTfCe16.Evh","sonar").  
%%% -------------------------------------------
qactor( gundam , ctxrobot, "it.unibo.gundam.MsgHandle_Gundam" ). 
qactor( gundam_ctrl , ctxrobot, "it.unibo.gundam.Gundam" ). 

