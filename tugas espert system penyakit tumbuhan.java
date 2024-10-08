import java.util.*;


public class CornDiseaseExpertSystem {

    private List<Rule> rules; // Daftar aturan (antecedent dan consequent)
    private ArrayList<String> questions; 
    private int[] answers; 
    private String selectedDisease; 
    private int answerLength; 
    private int startingIndex; 

    // Konstruktor
    public CornDiseaseExpertSystem() {
        this.questions = new ArrayList<>(); // Inisialisasi daftar pertanyaan
        this.rules = new ArrayList<>(); // Inisialisasi daftar aturan
        this.setRules(); // Menetapkan aturan untuk inferensi
    }

    // Menetapkan aturan inferensi berdasarkan gejala dan penyakit
    private void setRules() {
        // Aturan untuk Bulai
        rules.add(new Rule(List.of("G1", "G2", "G3", "G4", "G5"), "Bulai"));
        // Aturan untuk Blight
        rules.add(new Rule(List.of("G5", "G6", "G7", "G8", "G9"), "Blight"));
        // Aturan untuk Leaf Rust
        rules.add(new Rule(List.of("G10", "G11", "G12", "G13", "G14"), "Leaf Rust"));
        // Aturan untuk Burn
        rules.add(new Rule(List.of("G15", "G16", "G17", "G18", "G19"), "Burn"));
        // Aturan untuk Stem Borer
        rules.add(new Rule(List.of("G20", "G21", "G22", "G23", "G24"), "Stem Borer"));
        // Aturan untuk Cob Borer
        rules.add(new Rule(List.of("G25", "G26", "G27", "G28", "G29", "G30", "G31"), "Cob Borer"));
    }

    // Menampilkan pilihan penyakit untuk diperiksa
    public void chooseDisease() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pilih penyakit yang ingin diperiksa:");
        System.out.println("1. Bulai");
        System.out.println("2. Blight");
        System.out.println("3. Leaf Rust");
        System.out.println("4. Burn");
        System.out.println("5. Stem Borer");
        System.out.println("6. Cob Borer");
        System.out.print("Masukkan nomor pilihan (1-6): ");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                selectedDisease = "Bulai";
                setBulaiQuestions();
                answerLength = 5; 
                startingIndex = 1; 
                break;
            case 2:
                selectedDisease = "Blight";
                setBlightQuestions();
                answerLength = 5; 
                startingIndex = 5; 
                break;
            case 3:
                selectedDisease = "Leaf Rust";
                setLeafRustQuestions();
                answerLength = 5; 
                startingIndex = 10; 
                break;
            case 4:
                selectedDisease = "Burn";
                setBurnQuestions();
                answerLength = 5; 
                startingIndex = 15; 
                break;
            case 5:
                selectedDisease = "Stem Borer";
                setStemBorerQuestions();
                answerLength = 5; 
                startingIndex = 20; 
                break;
            case 6:
                selectedDisease = "Cob Borer";
                setCobBorerQuestions();
                answerLength = 7; 
                startingIndex = 25; 
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                System.exit(0);
        }

        // Inisialisasi ulang array `answers` sesuai panjang gejala penyakit yang dipilih
        this.answers = new int[answerLength];
    }

    // Menetapkan pertanyaan untuk penyakit Bulai
    private void setBulaiQuestions() {
        questions.clear(); // Membersihkan pertanyaan sebelumnya
        questions.add("Apakah daun berwarna klorotik? (G1)");
        questions.add("Apakah mengalami pertumbuhan terhambat? (G2)");
        questions.add("Apakah warna putih seperti tepung muncul pada permukaan daun? (G3)");
        questions.add("Apakah daun melengkung dan menggulung? (G4)");
        questions.add("Apakah pembentukan tongkol terganggu? (G5)");
    }

    // Menetapkan pertanyaan untuk penyakit Blight
    private void setBlightQuestions() {
        questions.clear();
        questions.add("Apakah pembentukan tongkol terganggu? (G5)");
        questions.add("Apakah daun yang terkena tampak layu? (G6)");
        questions.add("Apakah beberapa bercak kecil bergabung membentuk bercak lebih besar? (G7)");
        questions.add("Apakah terdapat bercak coklat terang memanjang berbentuk seperti perahu? (G8)");
        questions.add("Apakah terdapat bercak coklat berbentuk elips pada daun? (G9)");
    }

    // Menetapkan pertanyaan untuk penyakit Leaf Rust
    private void setLeafRustQuestions() {
        questions.clear();
        questions.add("Apakah daun terlihat kering? (G10)");
        questions.add("Apakah terdapat bercak kecil coklat atau kuning pada permukaan daun? (G11)");
        questions.add("Apakah terdapat bercak merah pada tulang daun? (G12)");
        questions.add("Apakah terdapat benang-benang putih yang tidak beraturan yang berubah menjadi coklat? (G13)");
        questions.add("Apakah terdapat serbuk kuning kecoklatan pada daun? (G14)");
    }

    // Menetapkan pertanyaan untuk penyakit Burn
    private void setBurnQuestions() {
        questions.clear();
        questions.add("Apakah terdapat pembengkakan pada tongkol? (G15)");
        questions.add("Apakah terdapat jamur putih hingga hitam pada biji? (G16)");
        questions.add("Apakah biji membengkak? (G17)");
        questions.add("Apakah kelenjar terbentuk di dalam biji? (G18)");
        questions.add("Apakah kelobot terbuka dan terdapat banyak jamur putih hingga hitam? (G19)");
    }

    // Menetapkan pertanyaan untuk penyakit Stem Borer
    private void setStemBorerQuestions() {
        questions.clear();
        questions.add("Apakah terdapat lubang kecil pada daun? (G20)");
        questions.add("Apakah terdapat celah pada batang? (G21)");
        questions.add("Apakah bunga jantan atau pangkal tongkol terkena? (G22)");
        questions.add("Apakah batang dan bunga jantan mudah patah? (G23)");
        questions.add("Apakah terdapat tumpukan bunga jantan yang patah? (G24)");
    }

    // Menetapkan pertanyaan untuk penyakit Cob Borer
    private void setCobBorerQuestions() {
        questions.clear();
        questions.add("Apakah bunga jantan tidak terbentuk? (G25)");
        questions.add("Apakah terdapat tepung/kotoran di sekitar tandan bunga? (G26)");
        questions.add("Apakah daun sedikit menguning? (G27)");
        questions.add("Apakah terdapat lubang melintang pada daun pada tahap vegetatif? (G28)");
        questions.add("Apakah rambut tongkol jagung terpotong, berkurang, atau kering? (G29)");
        questions.add("Apakah ujung tongkol bergoyang? (G30)");
        questions.add("Apakah sering terdapat larva? (G31)");
    }

    // Menampilkan pertanyaan kepada pengguna dan menerima input
    public void showQuestions() {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        for (String q : this.questions) {
            System.out.println(q);
            System.out.println("0. Tidak    1. Ya");
            int a = sc.nextInt();
            while (a != 0 && a != 1) {
                System.out.println("Jawaban tidak sesuai:v Silakan masukkan 0 atau 1.");
                a = sc.nextInt();
            }
            answers[i] = a; // Simpan jawaban
            i++;
        }
    }

    // Mengembalikan fakta (gejala) yang teramati oleh user
    public Set<String> getFacts() {
        Set<String> facts = new HashSet<>();
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == 1) {
                // Menambahkan gejala sesuai indeks penyakit yang dipilih
                facts.add("G" + (i + startingIndex));
            }
        }
        return facts;
    }

    // Melakukan inferensi berdasarkan aturan dan fakta yang ada
    public String inferDisease(Set<String> facts) {
        for (Rule rule : rules) {
            if (facts.containsAll(rule.getAntecedent())) {
                return rule.getConsequent(); // Mengembalikan nama penyakit jika semua antecedent cocok
            }
        }
        return "Tidak ada penyakit yang terdeteksi.";
    }

    // Menampilkan kesimpulan kepada user
    public void showConclusion(String disease, Set<String> facts) {
        System.out.println("Gejala yang teramati: " + facts);
        System.out.println("Kesimpulan: " + disease);
    }

    public static void main(String[] args) {
        // Membuat instance sistem pakar
        CornDiseaseExpertSystem system = new CornDiseaseExpertSystem();
        
        // Memilih penyakit untuk diperiksa
        system.chooseDisease();
        
        // Menampilkan pertanyaan dan menerima jawaban
        system.showQuestions();
        
        // Mendapatkan fakta (gejala) dari jawaban user
        Set<String> facts = system.getFacts();
        
        // Melakukan inferensi untuk mendeteksi penyakit
        String detectedDisease = system.inferDisease(facts);
        
        // Menampilkan kesimpulan1
        system.showConclusion(detectedDisease, facts);
    }
}

// Kelas Rule untuk mengelola antecedent (gejala) dan consequent (penyakit)
class Rule {
    private List<String> antecedent; // Daftar gejala (syarat)
    private String consequent; // Nama penyakit (hasil)

    public Rule(List<String> antecedent, String consequent) {
        this.antecedent = antecedent;
        this.consequent = consequent;
    }

    public List<String> getAntecedent() {
        return antecedent;
    }

    public String getConsequent() {
        return consequent;
    }
}
