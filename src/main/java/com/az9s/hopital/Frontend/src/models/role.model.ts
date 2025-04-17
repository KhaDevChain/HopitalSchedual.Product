import { Permission } from "./permission.model";

export interface Role {
    uniqueId: number;
    roleName: string;
    permissions: Permission[];
}
  