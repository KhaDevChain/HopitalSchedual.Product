import { User } from "./user.model";
import { UserRecord } from "./userrecord.model";

export interface Patient {
  uniqueId: string;
  medicalHistory: string;
  bloodType: string;
  insuranceId: string;
  user: User;
  userRecord: UserRecord
}
