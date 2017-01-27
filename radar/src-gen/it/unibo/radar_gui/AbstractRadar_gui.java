/* Generated by AN DISI Unibo */ 
package it.unibo.radar_gui;
import alice.tuprolog.Struct;
import alice.tuprolog.Term;
import it.unibo.qactors.QActorContext;
import it.unibo.qactors.ActorTerminationMessage;
import it.unibo.qactors.QActorMessage;
import it.unibo.qactors.QActorUtils;
import it.unibo.contactEvent.interfaces.IEventItem;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.action.ActionReceiveTimed;
import it.unibo.qactors.action.AsynchActionResult;
import it.unibo.qactors.action.IActorAction;
import it.unibo.qactors.action.IActorAction.ActionExecMode;
import it.unibo.qactors.action.IMsgQueue;
import it.unibo.qactors.akka.QActor;


//REGENERATE AKKA: QActor instead QActorPlanned
public abstract class AbstractRadar_gui extends QActor { 
	protected AsynchActionResult aar = null;
	protected boolean actionResult = true;
	protected alice.tuprolog.SolveInfo sol;
	//protected IMsgQueue mysupport ;  //defined in QActor
	protected String planFilePath    = null;
	protected String terminationEvId = "default";
	protected String parg="";
	protected boolean bres=false;
	protected IActorAction  action;
	
			protected static IOutputEnvView setTheEnv(IOutputEnvView outEnvView ){
				return outEnvView;
			}
	
	
		public AbstractRadar_gui(String actorId, QActorContext myCtx, IOutputEnvView outEnvView )  throws Exception{
			super(actorId, myCtx,  
			"./srcMore/it/unibo/radar_gui/WorldTheory.pl",
			setTheEnv( outEnvView )  , "init");		
			this.planFilePath = "./srcMore/it/unibo/radar_gui/plans.txt";
			//Plan interpretation is done in Prolog
			//if(planFilePath != null) planUtils.buildPlanTable(planFilePath);
	 	}
		@Override
		protected void doJob() throws Exception {
			String name  = getName().replace("_ctrl", "");
			mysupport = (IMsgQueue) QActorUtils.getQActor( name );
	 		initSensorSystem();
			boolean res = init();
			//println(getName() + " doJob " + res );
		} 
		/* 
		* ------------------------------------------------------------
		* PLANS
		* ------------------------------------------------------------
		*/
	    public boolean init() throws Exception{	//public to allow reflection
	    try{
	    	curPlanInExec =  "init";
	    	boolean returnValue = suspendWork;
	    while(true){
	    nPlanIter++;
	    		temporaryStr = "\"RADAR init the GUI ... \"";
	    		println( temporaryStr );  
	    		parg = "actorOp(activateGui)";
	    		//aar = solveGoalReactive(parg,3600000,"","");
	    		//genCheckAar(m.name)»
	    		QActorUtils.solveGoal(parg,pengine );
	    		if( ! planUtils.switchToPlan("doWorkMsgs").getGoon() ) break;
	    break;
	    }//while
	    return returnValue;
	    }catch(Exception e){
	       //println( getName() + " plan=init WARNING:" + e.getMessage() );
	       QActorContext.terminateQActorSystem(this); 
	       return false;  
	    }
	    }
	    public boolean doWorkMsgs() throws Exception{	//public to allow reflection
	    try{
	    	curPlanInExec =  "doWorkMsgs";
	    	boolean returnValue = suspendWork;
	    while(true){
	    nPlanIter++;
	    		temporaryStr = "\"RADAR receive\"";
	    		println( temporaryStr );  
	    		//ReceiveMsg
	    		 		 aar = planUtils.receiveAMsg(mysupport,30000000, "" , "" ); 	//could block
	    				if( aar.getInterrupted() ){
	    					curPlanInExec   = "playTheGame";
	    					if( ! aar.getGoon() ) break;
	    				} 			
	    				//if( ! aar.getGoon() ){
	    					//System.out.println("			WARNING: receiveMsg in " + getName() + " TOUT " + aar.getTimeRemained() + "/" +  30000000);
	    					//addRule("tout(receive,"+getName()+")");
	    				//} 		 
	    				//println(getName() + " received " + aar.getResult() );
	    		//onMsg
	    		if( currentMessage.msgId().equals("polar") ){
	    			String parg = "actorOp(sendDataToGui(DIST,THETA))";
	    			/* ActorOp */
	    			parg =  updateVars( Term.createTerm("p(Distance,Angle)"), Term.createTerm("p(DIST,THETA)"), 
	    				    		  					Term.createTerm(currentMessage.msgContent()), parg);
	    			if( parg != null ){
	    				aar = solveGoalReactive(parg,3600000,"","");
	    				//println(getName() + " plan " + curPlanInExec  +  " interrupted=" + aar.getInterrupted() + " action goon="+aar.getGoon());
	    				if( aar.getInterrupted() ){
	    					curPlanInExec   = "doWorkMsgs";
	    					if( ! aar.getGoon() ) break;
	    				} 			
	    			}
	    		}if( planUtils.repeatPlan(0).getGoon() ) continue;
	    break;
	    }//while
	    return returnValue;
	    }catch(Exception e){
	       //println( getName() + " plan=doWorkMsgs WARNING:" + e.getMessage() );
	       QActorContext.terminateQActorSystem(this); 
	       return false;  
	    }
	    }
	    protected void initSensorSystem(){
	    	//doing nothing in a QActor
	    }
	    
	 
		/* 
		* ------------------------------------------------------------
		* APPLICATION ACTIONS
		* ------------------------------------------------------------
		*/
		/* 
		* ------------------------------------------------------------
		* QUEUE  
		* ------------------------------------------------------------
		*/
		    protected void getMsgFromInputQueue(){
	//	    	println( " %%%% getMsgFromInputQueue" ); 
		    	QActorMessage msg = mysupport.getMsgFromQueue(); //blocking
	//	    	println( " %%%% getMsgFromInputQueue continues with " + msg );
		    	this.currentMessage = msg;
		    }
	  }
	
