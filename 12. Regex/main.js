//loading file
fs = require('fs');
const input = fs.readFileSync('vstup.html', 'utf8').replace(/\s/g, '');
//extracting data
const split = input.split('<tbody>');
const rows = split[1].split('</tr>');
const cells = rows.map(row => row.split('</td>'));
const text = cells.map(cell => cell.map(c => c.replace(/<[^>]*>/g, '')));
const sorted = text.sort((a, b) => a[10] - b[10]).filter(row => row[0] !== '');
//students parameters
const studentsNameRaw = sorted.map(student => student[0].replace(/[^a-zA-Z ]/g, '').split(/(?=[A-Z])/));
const studentsName = studentsNameRaw.map(student => student[0].toUpperCase() + " "+ student[1]);
const studentsProgram = sorted.map(student => student[10]);
const studentsIdRaw = sorted.map(student => student[7]);
const studentsIdLetter = studentsIdRaw.map(student => student.slice(0, 1));
const studentsIdNumber = studentsIdRaw.map(student => student.slice(1,-6));
//student object
function Students(name, program, faculty, id) {
    this.name = name;
    this.program = program;
    this.faculty = faculty;
    this.id = id;
}
const students = [];
for (let i = 0; i < studentsName.length; i++) {
    students.push(new Students(studentsName[i], studentsProgram[i], studentsIdLetter[i], studentsIdNumber[i]));
}
//It toke me 2 hours to figure out how to do this
const oddStudents = students.filter(student => student.id % 2 === 1).sort((a, b) => a.id - b.id);
const evenStudents = students.filter(student => student.id % 2 === 0).sort((a, b) => a.id - b.id);
studentsSorted = oddStudents.concat(evenStudents);
const studentsSortedByProgram = studentsSorted.sort((a, b) => a.program.localeCompare(b.program));
const studentsByProgram = studentsSortedByProgram.reduce((acc, student) => {
    if (!acc[student.program]) {
        acc[student.program] = [];
    }
    acc[student.program].push(student);
    return acc;
}, {});
//printing
for (let program in studentsByProgram) {
    console.log(program+':');
    for (let i = 0; i < studentsByProgram[program].length; i++) {
        let output = `${String((i+1)).padStart(2)}: ${studentsByProgram[program][i].faculty} ${studentsByProgram[program][i].name.padEnd(18)} ${studentsByProgram[program][i].program.padEnd(3)} ${studentsByProgram[program][i].id}`;
        console.log(output);
    }
    console.log();
}
