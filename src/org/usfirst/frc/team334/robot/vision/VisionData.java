package org.usfirst.frc.team334.robot.vision;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Roborio comms with TK1 for vision. 
 * To use, just create an instance and call getter methods.
 * 
 * double offset = VisionData.getOffset();
 */

public class VisionData {

    private static NetworkTable visionTable;

    private static double offset = 0;
    private static double switchDistance = 0;

    public VisionData() {
        visionTable = NetworkTableInstance.getDefault().getTable("vision");
        visionTable.addEntryListener((table, key, entry, value, flags) -> {
            System.out.println("key " + key + " value " + value.getDouble());
            switch (key) {
            case "center offset":
                offset = value.getDouble();
                break;
            case "distance":
                switchDistance = value.getDouble();
                break;
            }
        }, EntryListenerFlags.kUpdate);
    }

    public static double getOffset() {
        return offset;
    }

    public static double getSwitchDistance() {
        return switchDistance;
    }

}
