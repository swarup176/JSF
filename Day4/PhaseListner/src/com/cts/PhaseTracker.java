package com.cts;

import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseListener;
import javax.faces.event.PhaseId;

public class PhaseTracker implements PhaseListener {
   private static final String PHASE_PARAMETER ="com.cts.phaseTracker.phase";
   private static final Logger logger = Logger.getLogger("com.cts.phases");
   private static String phase = null;

   public void setPhase(String newValue) {
	   System.out.println("st****Phase.>>>>..."+newValue)
	   ;phase = newValue; 
   System.out.println("Phase...."+phase);}
   
   public PhaseId getPhaseId() {
	   System.out.println("get Phase...."+phase);
      if (phase == null) {
         FacesContext context = FacesContext.getCurrentInstance();
         phase = (String) context.getExternalContext().getInitParameter(
                                                         PHASE_PARAMETER);
         System.out.println("Phase...."+phase);
      }
      PhaseId phaseId = PhaseId.ANY_PHASE;

      if (phase != null) {
         if ("RESTORE_VIEW".equals(phase)) 
            phaseId = PhaseId.RESTORE_VIEW;
         else if ("APPLY_REQUEST_VALUES".equals(phase)) 
            phaseId = PhaseId.APPLY_REQUEST_VALUES;
         else if ("PROCESS_VALIDATIONS".equals(phase)) 
            phaseId = PhaseId.PROCESS_VALIDATIONS;
         else if ("UPDATE_MODEL_VALUES".equals(phase)) 
            phaseId = PhaseId.UPDATE_MODEL_VALUES;
         else if ("INVOKE_APPLICATION".equals(phase)) 
            phaseId = PhaseId.INVOKE_APPLICATION;
         else if ("RENDER_RESPONSE".equals(phase)) 
            phaseId = PhaseId.RENDER_RESPONSE;
         else if ("ANY_PHASE".equals(phase)) 
            phaseId = PhaseId.ANY_PHASE;
      }
      return phaseId;
   }
   public void beforePhase(PhaseEvent e) {
	   System.out.println("BEFORE >>>" + e.getPhaseId());
   }
   public void afterPhase(PhaseEvent e) {
	   System.out.println("AFTER >>>" + e.getPhaseId());
   }
}
