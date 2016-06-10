Beispiel für ein lokales Repository mit Projekt-Abhängigkeiten
==============================================================

Dieses Beispiel ist abgeleitet von unserem SpringBoot-Beispiel.

Manchmal muß man in Umgebungen arbeiten, die keinen Zugriff
auf externe Projekt-Repositories wie MavenCentral haben
und bei denen auch kein interner Repository-Spiegel wie Nexus
zur Verfügung steht.

Da ist es unerläßlich, dass die Dritt-Anbieter-Jars im Projekt
abgelegt und auch in's Source-Code-Verwaltungssystem mit eingecheckt
werden.

Dieses Projekt liefert dazu eine Grundlage. Der Workflow sieht so
aus:

* Projekt in eine "freie" Umgebung kopieren
* Dort bauen: `gradle war`
* Dritt-Anbieter-Jars kopieren: `gradle syncRemoteRepositories`
  (dauert ewig)
* Dritt-Anbieter-Jars einchecken: `git add syncRepo; git commit ...`
* Projekt in die "geschlossene" Umgebung kopieren
* Dort bauen: `gradle --offline war`

Der ganze Mechanismus basiert auf [IvyPot](https://github.com/ysb33r/ivypot-gradle-plugin).
