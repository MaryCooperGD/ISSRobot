%====================================================================================
% Context ctxAvatar  SYSTEM-configuration: file it.unibo.ctxAvatar.robot.pl 
%====================================================================================
context(ctxavatar, "localhost",  "TCP", "8070" ).  		 
%%% -------------------------------------------
%%% -------------------------------------------
%%% -------------------------------------------
qactor( avatar , ctxavatar, "it.unibo.avatar.MsgHandle_Avatar" ). 
qactor( avatar_ctrl , ctxavatar, "it.unibo.avatar.Avatar" ). 

