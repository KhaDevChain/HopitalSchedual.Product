import { Doctor } from "./doctor.model";

export interface Specialty {
  uniqueId: number;
  specialtyName: string;
  doctors: Doctor[];
}