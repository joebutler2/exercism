// time 46, +2 mins for TS specific refactoring.
type GradeLevel = Map<string, string>;
type Roster = Map<string, string[]>;

export default class GradeSchool {
  grades: GradeLevel;
  constructor() {
    this.grades = new Map();
  }
  
  addStudent(name: string, grade: number): void {
    this.grades.set(name, `${grade}`);
  }

  studentRoster(): Roster {
    return this.genRoster();
  }

  studentsInGrade(grade: number): string[] {
    return this.genRoster().get(grade + "") || [];
  }

  private genRoster(): Roster {
    const roster = new Map<string, string[]>();
    this.grades.forEach((grade, name) => {
      if(!roster.has(grade)) {
        roster.set(grade, []);
      }
      roster.get(grade).push(name);
    });
    for(const [_grade, students] of roster) {
      (students as string[]).sort();
    }
    return roster;
  }
}
