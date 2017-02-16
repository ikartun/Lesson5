package by.epam.tr.lesson5;

import java.util.Arrays;
import java.util.Comparator;

public class Task2 { //Task2 - it's a NoteBook
	private Note[] notes;	

	public void setNotes(Note[] notes) {
		this.notes = notes;
	}

	public static void main(String[] args) {
		Task2 task = new Task2();
		Note note1 = task.new Note("note1", 2, "22222");
		Note note2 = task.new Note("note1", 2, "11111");
		Note note3 = task.new Note("note3", 3, "33333");
		Note[] notes = new Note[] {note1, note2, note3};
		task.setNotes(notes);
		
		Note[] searchedNotes = task.searchNote("note3", 3, "33333");
		for (Note note : searchedNotes) {
			System.out.println(note);
		}
		System.out.println("----------------------------------------------");
		
		Note[] addedNotes = task.addNote(task.new Note("note4", 4, "44444"));
		for (Note note : addedNotes) {
			System.out.println(note);
		}
		System.out.println("----------------------------------------------");
		
		Note[] removedNotes = task.removeNote(task.new Note("note3", 3, "33333"));
		for (Note note : removedNotes) {
			System.out.println(note);
		}
		System.out.println("----------------------------------------------");
		
		task.sortNoteByAllField();
		for (Note note : task.notes) {
			System.out.println(note);
		}
		

	}
	
	public Note[] searchNote(String name, int age, String phone) {
		int index = 0;
		
		for (Note note : notes) {
			if (note.name.equals(name) || note.age == age || note.phone.equals(phone)) {
				index++;
			}
		}
		
		Note[] resultNotes = new Note[index];
		index = 0;
		
		for (Note note : notes) {
			if (note.name.equals(name) || note.age == age || note.phone.equals(phone)) {
				resultNotes[index] = note;
				index++;
			}
		}		
		return resultNotes;
	}
	
	public Note[] addNote(Note note) {
		int index = 0;
		Note[] resultNotes = new Note[notes.length + 1];
		
		for (Note note1 : notes) {
			resultNotes[index] = note1;
			index++;
		}
		
		resultNotes[index] = note;
		
		return resultNotes;
	}
	
	public Note[] removeNote(Note note) {
		int index = 0;
		Note[] resultNotes = new Note[notes.length - 1];
		
		for (Note note1 : notes) {
			if (!note1.name.equals(note.name) && note1.age != note.age && !note1.phone.equals(note.phone)) {
				resultNotes[index] = note1;
				index++;
			}
		}		
		return resultNotes;
	}
	
	public void sortNoteByAllField() {
		Arrays.sort(notes, new Comparator<Note>() {
			@Override
			public int compare(Note o1, Note o2) {
				if (o1.name.compareTo(o2.name) == 0) {
					if (((Integer) o1.age).compareTo(((Integer) o2.age)) == 0) {
						return o1.phone.compareTo(o2.phone);
					}
					else {
						return ((Integer) o1.age).compareTo(((Integer) o2.age));
					}
				}
				else {
					return o1.name.compareTo(o2.name);
				}
			}
		});
	}
	
	public class Note {
		private String name;
		private int age;
		private String phone;
		
		public Note(String name, int age, String phone) {
			super();
			this.name = name;
			this.age = age;
			this.phone = phone;
		}

		@Override
		public String toString() {
			return "Name is " + name + ", age is " + age + ", phone is " + phone;
		}		
	}

}
