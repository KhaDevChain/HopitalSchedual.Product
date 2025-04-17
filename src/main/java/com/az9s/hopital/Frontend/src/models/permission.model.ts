import { Role } from "./role.model";

export interface Permission {
    uniqueId: string;
    groupName: string;
    groupPermission: string;
    description?: string;
    createdAt: Date;
    activated: string; // ACTIVE | INACTIVE | PENDING
    role: Role;
}
