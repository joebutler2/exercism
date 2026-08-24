// time 46, +2 mins for TS specific refactoring.
type GradeLevel = Map<string, number>;
type Roster = {[gradeLevel: number]: string[]};

export class GradeSchool {
  grades: GradeLevel;
  constructor() {
    this.grades = new Map();
  }
  
  add(name: string, grade: number): void {
    this.grades.set(name, grade);
  }

  roster(): Roster {
    return this.genRoster();
  }

  grade(grade: number): string[] {
    return this.genRoster()[grade] || [];
  }

  private genRoster(): Roster {
    const roster: Roster = {};
    this.grades.forEach((grade, name) => {
      roster[grade] ||= [];
      roster[grade]!!.push(name);
    });
    for(const [_grade, students] of Object.entries(roster)) {
      (students as string[]).sort();
    }
    return roster;
  }
}
