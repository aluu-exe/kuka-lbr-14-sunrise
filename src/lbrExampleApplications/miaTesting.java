package lbrExampleApplications;

import com.kuka.roboticsAPI.applicationModel.RoboticsAPIApplication;
import static com.kuka.roboticsAPI.motionModel.BasicMotions.*;
import com.kuka.roboticsAPI.deviceModel.LBR;
import com.kuka.roboticsAPI.motionModel.PTP;
import com.kuka.roboticsAPI.uiModel.ApplicationDialogType;

public class miaTesting extends RoboticsAPIApplication {
	private LBR lbr;
	private final static String informationText=
         "This application is intended for floor mounted robots!"+ "\n" +
			"\n" +
			"This script is for mia's testing";

	public void initialize() {
		lbr = getContext().getDeviceFromType(LBR.class);
	}

	public void run() {
		getLogger().info("Show modal dialog and wait for user to confirm");
        int isCancel = getApplicationUI().displayModalDialog(ApplicationDialogType.QUESTION, informationText, "OK", "Cancel");
        if (isCancel == 1)
        {
            return;
        }

		getLogger().info("Testing basic linear motion");
		
		PTP ptpToTransportPosition = ptp(0, Math.toRadians(25), 0, Math.toRadians(90), 0, 0, 0);
		ptpToTransportPosition.setJointVelocityRel(0.25);
		lbr.move(ptpToTransportPosition);
	}

}
