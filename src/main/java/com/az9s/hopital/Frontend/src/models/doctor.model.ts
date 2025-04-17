import { Specialty } from "./specialty.model";
import { User } from "./user.model";
import { UserRecord } from "./userrecord.model";

export interface Doctor {
  uniqueId: string;
  specialization: string;
  experienceYears: number;
  licenseNumber: string;
  user?: User;
  userRecord?: UserRecord;
  specialty?: Specialty;
}
