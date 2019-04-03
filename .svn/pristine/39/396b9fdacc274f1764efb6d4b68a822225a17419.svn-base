google.load("visualization", "1");

      // Set callback to run when API is loaded
      google.setOnLoadCallback(drawVisualization);

      // Called when the Visualization API is loaded.
      function drawVisualization() {
        // Create and populate a data table.
        /*var data = new google.visualization.DataTable();
        data.addColumn('datetime', 'start');
        data.addColumn('datetime', 'end');
        data.addColumn('string', 'content');

        data.addRows([
          [new Date(2010,7,23), , 'Conversation<br>' +
            '<img src="img/comments-icon.png" style="width:32px; height:32px;">'],
          [new Date(2010,7,23,23,0,0), , 'Mail from boss<br>' +
            '<img src="img/mail-icon.png" style="width:32px; height:32px;">'],
          [new Date(2010,7,24,16,0,0), , 'Report'],
          [new Date(2010,7,26), new Date(2010,8,2), 'Traject A'],
          [new Date(2010,7,28), , 'Memo<br>' +
            '<img src="img/notes-edit-icon.png" style="width:48px; height:48px;">'],
          [new Date(2010,7,29), , 'Phone call<br>' +
            '<img src="img/Hardware-Mobile-Phone-icon.png" style="width:32px; height:32px;">'],
          [new Date(2010,7,31), new Date(2010,8,3), 'Traject B'],
          [new Date(2010,8,4,12,0,0), , 'Report<br>' +
            '<img src="img/attachment-icon.png" style="width:32px; height:32px;">']
        ]);*/
        
        var dataJSON = [];

        dataJSON.push({
          'start': new Date(2010, 7, 15),
          //'end': new Date(2010, 7, 16),  // end is optional
          'content': "<div>Test Farma</div><img src='/idea/img/iconos/testfarma.png' style='width:32px; height:32px;'>"
          // Optional: a parameter 'group'
          // Optional: a parameter 'className'
        },
        {
          'start': new Date(2011, 8, 15),
          'content': "<div>Registrador de Eventos</div>"
          // Optional: a parameter 'group'
          // Optional: a parameter 'className'
          }
        ,
        {
          'start': new Date(2012, 8, 15,13,0,0),
          'content': "<div>Almuerzo</div>"
          // Optional: a parameter 'group'
          // Optional: a parameter 'className'
          });

        // specify options
        options = {
          "width":  "100%",
          "height": "99%",
          "style": "box", 
          "minHeight": 150
        };
        
        var obj = document.getElementById('frr');
        //alert(obj.toString());
        //alert('eeeeooooooo');
        // Instantiate our timeline object.
        var timeline = new links.Timeline(document.getElementById('mytimeline'));

        // Draw our timeline with the created data and options
        //timeline.draw(data, options);
        timeline.draw(dataJSON, options);
      }