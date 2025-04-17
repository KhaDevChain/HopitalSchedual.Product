import { User } from "./user.model";

export interface UserRecord {
  uniqueId: string;
  fullName: string;
  dateOfBirth: string;
  gender: string;
  address: string;
  avatar: string;
  user: User
}
