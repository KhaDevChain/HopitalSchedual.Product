import { Role } from "./role.model";
import { UserRecord } from "./userrecord.model";

export interface User {
  uniqueId: string;
  phone: string;
  password: string;
  email: string;
  createdAt: Date;
  activated: string; // ACTIVE | INACTIVE | PENDING
  role: Role;
  userRecord?: UserRecord;
}
