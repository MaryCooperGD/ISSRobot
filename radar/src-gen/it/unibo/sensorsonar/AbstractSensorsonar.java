/* Generated by AN DISI Unibo */ 
package it.unibo.sensorsonar;
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
public abstract class AbstractSensorsonar extends QActor { 
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
	
	
		public AbstractSensorsonar(String actorId, QActorContext myCtx, IOutputEnvView outEnvView )  throws Exception{
			super(actorId, myCtx,  
			"./srcMore/it/unibo/sensorsonar/WorldTheory.pl",
			setTheEnv( outEnvView )  , "init");		
			this.planFilePath = "./srcMore/it/unibo/sensorsonar/plans.txt";
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
	    		temporaryStr = "\"sensorsonar STARTS\"";
	    		println( temporaryStr );  
	    		if( (guardVars = QActorUtils.evalTheGuard(this, " !?onRaspberry" )) != null ){
	    		parg = "actorOp(startSonarC)";
	    		parg = QActorUtils.substituteVars(guardVars,parg);
	    		//aar = solveGoalReactive(parg,3600000,"","");
	    		//genCheckAar(m.name)»
	    		QActorUtils.solveGoal(parg,pengine );
	    		}
	    		parg = "setmyposition";
	    		//tout=1 day (24 h)
	    		//aar = solveGoalReactive(parg,86400000,"","");
	    		//genCheckAar(m.name)»		
	    		QActorUtils.solveGoal(parg,pengine );
	    		if( (guardVars = QActorUtils.evalTheGuard(this, " !?position(POS)" )) != null ){
	    		temporaryStr = "position(POS)";
	    		temporaryStr = QActorUtils.substituteVars(guardVars,temporaryStr);
	    		println( temporaryStr );  
	    		}
	    		if( (guardVars = QActorUtils.evalTheGuard(this, " !?numOfSonars(N)" )) != null ){
	    		temporaryStr = "numOfSonars(N)";
	    		temporaryStr = QActorUtils.substituteVars(guardVars,temporaryStr);
	    		println( temporaryStr );  
	    		}
	    		if( ! planUtils.switchToPlan("workSimulate").getGoon() ) break;
	    		temporaryStr = "\"sensorsonar workReal\"";
	    		println( temporaryStr );  
	    		if( (guardVars = QActorUtils.evalTheGuard(this, " !?onRaspberry" )) != null ){
	    		if( ! planUtils.switchToPlan("workReal").getGoon() ) break;
	    		}
	    break;
	    }//while
	    return returnValue;
	    }catch(Exception e){
	       //println( getName() + " plan=init WARNING:" + e.getMessage() );
	       QActorContext.terminateQActorSystem(this); 
	       return false;  
	    }
	    }
	    public boolean workSimulate() throws Exception{	//public to allow reflection
	    try{
	    	curPlanInExec =  "workSimulate";
	    	boolean returnValue = suspendWork;
	    while(true){
	    nPlanIter++;
	    		if( (guardVars = QActorUtils.evalTheGuard(this, " !?p(D,POS,N)" )) != null ){
	    		temporaryStr = "p(D,POS,N)";
	    		temporaryStr = QActorUtils.substituteVars(guardVars,temporaryStr);
	    		println( temporaryStr );  
	    		}
	    		else{ println( "bye" );
	    		returnValue = continueWork;
	    		//QActorContext.terminateQActorSystem(this);
	    		break;
	    		}if( (guardVars = QActorUtils.evalTheGuard(this, " ??p(D,POS,N)" )) != null ){
	    		temporaryStr = QActorUtils.unifyMsgContent(pengine, "p(Distance,Angle,Num)","p(D,POS,N)", guardVars ).toString();
	    		emit( "sonar", temporaryStr );
	    		}
	    		//delay
	    		aar = delayReactive(500,"" , "");
	    		if( aar.getInterrupted() ) curPlanInExec   = "workSimulate";
	    		if( ! aar.getGoon() ) break;
	    		if( planUtils.repeatPlan(29).getGoon() ) continue;
	    		returnValue = continueWork;  
	    break;
	    }//while
	    return returnValue;
	    }catch(Exception e){
	       //println( getName() + " plan=workSimulate WARNING:" + e.getMessage() );
	       QActorContext.terminateQActorSystem(this); 
	       return false;  
	    }
	    }
	    public boolean workReal() throws Exception{	//public to allow reflection
	    try{
	    	curPlanInExec =  "workReal";
	    	boolean returnValue = suspendWork;
	    while(true){
	    nPlanIter++;
	    		parg = "actorOp(getDistanceFromSonar)";
	    		//aar = solveGoalReactive(parg,3600000,"","");
	    		//genCheckAar(m.name)»
	    		QActorUtils.solveGoal(parg,pengine );
	    		if( (guardVars = QActorUtils.evalTheGuard(this, " !?obstacledata(VAL)" )) != null ){
	    		temporaryStr = "VAL";
	    		temporaryStr = QActorUtils.substituteVars(guardVars,temporaryStr);
	    		println( temporaryStr );  
	    		}
	    		if( (guardVars = QActorUtils.evalTheGuard(this, " !?obstacledata(VAL)" )) != null ){
	    		temporaryStr = QActorUtils.unifyMsgContent(pengine, "p(Distance,Angle,Num)","VAL", guardVars ).toString();
	    		emit( "sonar", temporaryStr );
	    		}
	    		if( (guardVars = QActorUtils.evalTheGuard(this, " ??actorOpDone(OP,R)" )) != null ){
	    		temporaryStr = "R";
	    		temporaryStr = QActorUtils.substituteVars(guardVars,temporaryStr);
	    		println( temporaryStr );  
	    		}
	    		if( planUtils.repeatPlan(0).getGoon() ) continue;
	    break;
	    }//while
	    return returnValue;
	    }catch(Exception e){
	       //println( getName() + " plan=workReal WARNING:" + e.getMessage() );
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
	
