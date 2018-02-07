package org.usfirst.frc.team334.robot.vision;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class VisionData {

	private double offset = 0;

	public VisionData() {
		NetworkTable nt = NetworkTableInstance.getDefault().getTable("vision");
        nt.addEntryListener((table, key, entry, value, flags) -> {
            System.out.println("key " + key + " value " + value.getDouble());
            switch (key) {
                case "center offset":
                    offset = value.getDouble();
                    break;
            }
        }, EntryListenerFlags.kUpdate);
	}

	public double getOffset() {
        return this.offset;
    }
}
