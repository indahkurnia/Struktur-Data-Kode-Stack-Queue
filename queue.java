package queueantrian;

import java.util.Scanner;

public class appQueue {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    cQueue cq = new cQueue();
    String l = "------------------------------";
    int pilih = 0, nomor = 1;
    do {
      System.out.println(l + "\n" + l + "\n MENU QUEUE MAHASISWA\n" + l);
      System.out.println("\t[1] Enqueue\n\t[2] Dequeue\n\t[3] Print\n\t[4] Exit");
      System.out.println(l + "\nPilih = ");
      pilih = s.nextInt();
      System.out.println(l);
      switch (pilih) {
        case 1:
          System.out.println(" = Input Data Mahasiswa =\n");
          System.out.println("Masukkan Nama = ");
          String nm = s.next();
          cObject t = new cObject(nm, np, nomor);
          nomor++;
          cq.enqueue(t);
          System.out.println("");
          break;

        case 2:
          t = cq.dequeue();
          if (t == null) {
            System.out.println("\n[ Tidak ada data ] \n");
          } else {
            System.out.println(l + "\n\n[");
            System.out.printf("     %-15%s         %-15s", t.getnama() + " selesai", " ]\n");
          }
          System.out.println("");
          break;

        case 3:
          cq.print();
          break;

        case 4:
          System.out.println("\n                = Terima Kasih =\n");
          break;
      }
    } while (pilih != 4);
  }
}

public class cQueue {
  cObject front, rear;
  int size;
  private String l = "..................................";

  cQueue() {
    front = rear = null;
    size = 0;
  }

  public void enqueue(cObject baru) {
    if (rear == null) {
      front = rear = baru;
    } else {
      rear.next = baru;
      baru.prev = rear;
      rear = baru;
    }
    size++;
  }

  public cObject dequeue() {
    if (front == null) {
      return (null);
    } else if (front.next == null) {
      // queue tinggal berisi 1 object
      cObject t = rear;
      front = rear = null;
      size--;
      return (t);
    } else {
      // queue berisi >1 object
      cObject t = front.next;
      cObject t2 = front;
      t2.next = null;
      front = t;
      front.prev = null;
      size--;
      return (t2);
    }
  }

  public void print() {
    System.out.println("  = Data Antrian Mahasiswa =\n");
    System.out.println("Banyak Antrian : " + size);
    System.out.println(l + "\n  Nama Mahasiswa      No.Antrian\n" + l);
    for (cObject t = front; t != null; t = t.next) {
      System.out.printf("%-15s        %03d%n", "> " + t.get.nama(), t.getno());
      System.out.println("  [ " + t.getnpm() + "  ]");
    }
    System.out.println(" ");
  }
}

public class cObject {
  cObject next;
  cObject prev;
  private String nama, npm;
  private int no;

  cObject(String n, String p, int o) {
    nama = n;
    npm = p;
    no = o;
  }

  public String getnama() {
    return nama;
  }

  public String getnpm() {
    return npm;
  }

  public int getno() {
    return no;
  }
}