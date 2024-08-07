package c2;

class Episode {

    int seriesNumber;
    int episodeNumber;

    void skipIntro () {
        System.out.println("Skipping intro ... ");

    }

    void skipToNext () {
        System.out.println ("Loading next episode ... ");

    }

    //play method added
    void play() {
        System.out.println("Playing...");
    }

}

class EpisodeTestDrive {
    public static void main(String[] args) {

        Episode episode = new Episode();
        episode.seriesNumber= 4;
        episode.play();
        episode.skipIntro();

    }

}