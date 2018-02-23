based on https://github.com/zhengyang-wang/Deeplab-v2--ResNet-101--Tensorflow
#Zusammenfassung
- files in /data  (images jpeg, masks png)
- preprocess_data.py  starten: konvertierung zu 512x512 und rotationen
- dataset/generate_dataset.py  -> filelisten erstellen
- main.py : verzeichnisse, parameter anpassen, starten zum trainieren
- export_model.py : iterations schritt anpassen, model als pb exportieren
- segment-py zum segmentieren, oder frozen_model_backup* zum visualisieren


# Segmentation
Mit Hilfe dieser Implementierung lassen sich Objekte segmentieren.

## 1. Vorraussetzungen
```
Python 3.5
Tensorflow 1.4.0
Jupyter Notebook
NVIDIA Grafikkarte (Optional für GPU basiertes Training)
```

## 2. Vorbereitungen
Das Skript *setup.sh* ausführen, um alle notwendigen Ordner zu erstellen
und das Resnet Checkfile herunterzuladen.
```
bash setup.sh
```

## 3. Training
Alle Daten für das Training im Verzeichnis *data* ablegen. Bilder liegen im
JPG Format vor, Masken im PNG Format. Das Notebook *preprocess_data.ipynb*
ausführen, um die Daten für das Training vorzubereiten. Die Bilder werden auf
das Format 512x512 gebracht und entsprechende 1D Vectormasken erstellt.
Die Ergebnisse werden im Verzeichnis *data_preprocessed* abgelegt.

Update: preprocess_data.py verwenden -> file separator anpassen beim split

### 3.1 Dataset erstellen
Für das Training muss nun ein Dataset erstellt werden. Hierzu das Skript
*generate_dataset_txt.py* im Ordner *dataset* aufrufen. Es werden Textdateien mit Dateilisten für das Testen, Trainieren und Validieren erstellt.
```
python generate_dataset_txt.py
```

### 3.2 Training starten
Anschließend kann das Training gestartet werden. Hierzu einfach das Skript
*main.py* aufrufen.

```
python main.py
```

Nach belieben können die Hyperparameter im Skript *main.py* angepasst werden. Wichtig ist die Anzahl der Steps *num_steps* und das *save_interval*. Beim des Ausführen des Trainings auf einen fallenden Loss achten.

```
num_steps: how many iterations to train

save_interval: how many steps to save the model and save a checkpoint

random_seed: random seed for tensorflow

weight_decay: l2 regularization parameter

learning_rate: initial learning rate

power: parameter for poly learning rate
```

### 3.3 Tensorboard für die Visualisierung
Während des Trainings können sie jeden Checkpoint visualisieren. Hierzu im
Hauptverzeichnis folgenden Befehl ausführen.
```
tensorboard --logdir=log
```

## 4. Testing/Validation
Zum Testen und Validieren bitte zunächst die Parameter in der *Main.py* anpassen.
Zu Setzen ist die Checkpointnummer und die Anzahl der Validierungen (Anzahl der
Zeilen in der Datei *valid.txt* im Verzeichnis *data_preprocessed*)

```
valid_step: checkpoint number for testing/validation

valid_num_steps: = number of testing/validation samples
```
Danach das Skript *main.py* mit dem Parameter test folgendermaßen aufrufen.
```
python main.py --option=test
```
Sie erhalten dann die "pixel accuracy" und den "mean IoU". Zukünftig auch den
F1 Score.

### Validierung mit Notebook
Mit dem Notebook *validate.ipynb* können sie sich Validierungsergebnisse
grafisch anschauen. Bitte auch hier den Parameter *valid_num_steps* auf die Anzahl
der Validierungen stellen und die Checkpointnummer *valid_step* definieren.

Update: funktioniert nicht

## 5. Model veröffentlichen
Zur Veröffentlichung des Modells in anderen Anwendungen bitte das Notebook
*export_pb_file.ipynb* verwenden. Das Notebook erstellt eine *.pb Datei* mit
dem Namen *frozen_model.bp* im Hauptverzeichnis.

Update: export_pb_file.py verwenden

### Model vor der Auslieferung prüfen
Ob das fertige Modell fehlerfrei funktioniert, können Sie mit dem Notebook
*frozen_model_showcase.ipynb* überprüfen. Es verwendet die zuvor erstellt pb Datei
zur Interferenz. Zur Prüfung werden Beispieldateien aus dem Ordner *input_images*
verwendet.

## 6. Hinweise
Die Implementierung basiert auf der Arbeit *DeepLab v2 (ResNet-101) in TensorFlow*. Nachzuschlagen unter https://github.com/zhengyang-wang/Deeplab-v2--ResNet-101--Tensorflow
