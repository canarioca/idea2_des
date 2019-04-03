$(document).ready(function(){

      var events = [
      {dates: [new Date(2011, 2, 31)], title: "Admisión Paciente", section: 0},
      {dates: [new Date(2012, 1, 29)], title: "Mesa Basculante", section: 1},
      {dates: [new Date(2012, 3, 5)], title: "Mesa Basculante", section: 1},
      {dates: [new Date(2012, 3, 7)], title: "Test Farmacologico - Epinefrina", section: 1},
      {dates: [new Date(2012, 3, 8)], title: "Test Farmacológico - Flenicianida", section: 1},
      {dates: [new Date(2012, 3, 9)], title: "Mesa Basculante", section: 1},
      {dates: [new Date(2012, 3, 13)], title: "EEF", section: 2},
      {dates: [new Date(2012, 3, 9)], title: "Ablación", section: 2},
      {dates: [new Date(2012, 3, 13)], title: "EEF", section: 2},
      {dates: [new Date(2012, 3, 17)], title: "Cardioversión", section: 2},
      {dates: [new Date(2012, 3, 20)], title: "Implante MP", section: 2},
      {dates: [new Date(2012, 3, 5)], title: "Revisión MP", section: 3},
      {dates: [new Date(2012, 2, 28)], title: "Revisión MP", section: 3, description: "Played in Japan!"},
      {dates: [new Date(2012, 4, 18)], title: "Revisión MP", section: 3},
      {dates: [new Date(2012, 5, 10)], title: "Revisión MP", section: 3},
      {dates: [new Date(2012, 9, 24)], title: "Explante MP", section: 3}
      ];

      var sections = [
      {dates: [new Date(2012, 1, 31), new Date(2012, 2, 1)], title: "Admisión", section: 0, attrs: {fill: "#d4e3fd"}},
      {dates: [new Date(2012, 2, 1), new Date(2012, 9, 3)], title: "Diagnostico", section: 1, attrs: {fill: "#d4e3fd"}},
      {dates: [new Date(2012, 1, 29), new Date(2012, 3, 4)], title: "Tratamiento", section: 2, attrs: {fill: "#eaf0fa"}},
      {dates: [new Date(2012, 9, 4), new Date(2012, 9, 31)], title: "Seguimiento", section: 3, attrs: {fill: "#eaf0fa"}},
      
      ];
      
      var sectionsEvolucion = [
         {dates: [new Date(2012, 1, 31), new Date(2012, 9, 24)], title: "Evolución eventos", section: 0, attrs: {fill: "#d4e3fd"}},                   
       ];

      var timeline1 = new Chronoline(document.getElementById("target1"), events,
        {animated: true,
         tooltips: true,
         defaultStartDate: new Date(2012, 3, 5),
         sections: sections,
         sectionLabelAttrs: {'fill': '#997e3d', 'font-weight': 'bold'},
      });

      $('#to-today').click(function(){timeline1.goToToday();});

      var sections2 = [
      {dates: [new Date(2011, 2, 31), new Date(2011, 9, 28)], title: "2011 MLB Season", section: 0, attrs: {fill: "##e3f0fe"}},
      {dates: [new Date(2012, 2, 28), new Date(2012, 9, 3)], title: "2012 MLB Regular Season", section: 1, attrs: {fill: "#e3f0fe"}},
      {dates: [new Date(2012, 1, 29), new Date(2012, 3, 4)], title: "Spring Training", section: 2, attrs: {fill: "#cce5ff"}},
      {dates: [new Date(2012, 9, 4), new Date(2012, 9, 31)], title: "2012 MLB Playoffs", section: 3, attrs: {fill: "#cce5ff"}}
      ];

      var timeline2 = new Chronoline(document.getElementById("target2"), events,
        {visibleSpan: DAY_IN_MILLISECONDS * 91,
      animated: true,
         tooltips: true,
         defaultStartDate: new Date(2012, 1, 1),
         sections: sections,
         sectionLabelAttrs: {'fill': '#997e3d', 'font-weight': 'bold'},
      labelInterval: isFifthDay,
      hashInterval: isFifthDay,
      scrollLeft: prevMonth,
      scrollRight: nextMonth,
      markToday: 'labelBox',
         draggable: true
      });

      var timeline3 = new Chronoline(document.getElementById("target3"), events,
        {visibleSpan: DAY_IN_MILLISECONDS * 366,
      animated: true,
         tooltips: true,
         defaultStartDate: new Date(2012, 3, 5),
         sections: sections,
         sectionLabelAttrs: {'fill': '#997e3d', 'font-weight': 'bold'},
      labelInterval: isHalfMonth,
      hashInterval: isHalfMonth,
      scrollLeft: prevQuarter,
      scrollRight: nextQuarter,
      floatingSubLabels: false,
      });

      });