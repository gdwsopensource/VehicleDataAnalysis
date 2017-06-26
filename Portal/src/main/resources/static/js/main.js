$(function() {
	//引入地图
	var dom = document.getElementById('map');
	var myChart = echarts.init(dom);

	var option = null;
	myChart.setOption(option = {
		title: {
			text: '交通概览图',
			textStyle: {
				color: '#fff'
			},
			top: 10,
			left: 10,
		},
		legend: {
			data: ['严重警告', '中度警告', '低度警告'],
			textStyle: {
				color: '#fff'
			},
			orient: 'vertical',
			right: '2%',
			bottom: '5%'
		},
		bmap: {
			center: [113.366286, 23.130748], //113.366286,23.130748 天河
			zoom: 14,
			roam: true,
			mapStyle: {
				styleJson: [{
					'featureType': 'water',
					'elementType': 'all',
					'stylers': {
						'color': '#08233e'
					}
				}, {
					'featureType': 'land',
					'elementType': 'all',
					'stylers': {
						'color': '#08233e'
					}
				}, {
					'featureType': 'railway',
					'elementType': 'all',
					'stylers': {
						'visibility': 'off'
					}
				}, {
					'featureType': 'highway',//高速
					'elementType': 'geometry',
					'stylers': {
						'color': '#227eda',
						'weight': '0.1'
					}
				}, {
					'featureType': 'highway',
					'elementType': 'labels',
					'stylers': {
						'color': '#ffffff'
					}
				}, {
					'featureType': 'highway',
					'elementType': 'labels.text.stroke',
					'stylers': {
						'color': 'transparent'
					}
				},{
					'featureType': 'arterial',//城市主路
					'elementType': 'geometry',
					'stylers': {
						'color': '#227eda',
						'weight': '0.1'
					}
				}, {
					'featureType': 'arterial',
					'elementType': 'labels',
					'stylers': {
						'color': '#ffffff'
					}
				}, {
					'featureType': 'arterial',
					'elementType': 'labels.text.stroke',
					'stylers': {
						'color': 'transparent'
					}
				}, {
					'featureType': 'poi',
					'elementType': 'all',
					'stylers': {
						'visibility': 'off'
					}
				}, {
					'featureType': 'green',
					'elementType': 'all',
					'stylers': {
						'visibility': 'off'
					}
				}, {
					'featureType': 'subway',
					'elementType': 'all',
					'stylers': {
						'visibility': 'off'
					}
				}, {
					'featureType': 'manmade',
					'elementType': 'all',
					'stylers': {
						'color': '#08233e'
					}
				}, {
					'featureType': 'local',
					'elementType': 'all',
					'stylers': {
						'color': '#08233e'
					}
				}, {
					'featureType': 'boundary',
					'elementType': 'all',
					'stylers': {
						'color': '#fefefe'
					}
				}, {
					'featureType': 'building',
					'elementType': 'all',
					'stylers': {
						'color': '#08233e'
					}
				}, {
					'featureType': 'label',
					'elementType': 'labels.text.fill',
					'stylers': {
						'color': '#ffffff',
						'weight': '0.1'
					}
				}, {
					'featureType': 'label',
					'elementType': 'labels.text.stroke',
					'stylers': {
						'color': 'transparent',
						'weight': '0.1'
					}
				}]
			}
		},
		tooltip: {
			trigger: 'item'
		},
		series: [{
			name: 'checkpoint',
			type: 'scatter',
			coordinateSystem: 'bmap',
			data: [{
				name: '天河',
				value: [113.366286, 23.132748]
			}],
			symbol: 'image://../images/addr.png',
			symbolSize: 20
		}, {
			name: '严重警告', //严重预警
			type: 'effectScatter',
			coordinateSystem: 'bmap',
			data: [{
				name: '天河1',
				value: [113.366281, 23.130748]
			}, {
				name: '天河2',
				value: [113.366246, 23.130248]
			}, {
				name: '天河5',
				value: [113.366276, 23.130758]
			}, {
				name: '天河6',
				value: [113.366186, 23.130728]
			}],
			symbol: 'circle',
			showEffectOn: 'render',
			rippleEffect: {
				brushType: 'stroke'
			},
			itemStyle: {
				normal: {
					color: '#e60012',
					shadowBlur: 10,
					shadowColor: '#333'
				}
			},
			zlevel: 1
		}, {
			name: '中度警告', //中度预警
			type: 'effectScatter',
			coordinateSystem: 'bmap',
			data: [{
				name: '上海',
				value: [113.366287, 23.130744]
			}, {
				name: '广州',
				value: [113.366186, 23.130148]
			}],
			symbol: 'circle',
			showEffectOn: 'render',
			rippleEffect: {
				brushType: 'stroke'
			},
			itemStyle: {
				normal: {
					color: '#ff8520',
					shadowBlur: 10,
					shadowColor: '#333'
				}
			},
		}, {
			name: '低度警告', //低度预警
			type: 'effectScatter',
			coordinateSystem: 'bmap',
			data: [{
				name: '天河3',
				value: [113.366186, 23.130738]
			}, {
				name: '天河4',
				value: [113.366216, 23.130248]
			}],
			symbol: 'circle',
			showEffectOn: 'render',
			rippleEffect: {
				brushType: 'stroke'
			},
			itemStyle: {
				normal: {
					color: '#ffed27',
					shadowBlur: 10,
					shadowColor: '#333'
				}
			},
		}]
	});
	if(option && typeof option === 'object') {
		myChart.setOption(option, true);
		var bmap = myChart.getModel().getComponent('bmap').getBMap();
		bmap.enableDragging();
		myChart.on('click', function(params) {
			if(params.seriesName=='checkpoint'){
				console.log(params);
				var pointName=params.name,
					carNum='粤Axxxx',
					travelTime='09:00-10:00',
					warningType='逾期未年检';
				var th='<tr><th>卡口</th><th>车辆</th><th>时间段</th><th>预警类型</th></tr>';
				var tbody=null;
				for(var i=0;i<20;i++){
					tbody+='<tr><td>'+pointName
						+'</td><td>'+carNum
						+'</td><td>'+travelTime
						+'</td><td>'+warningType
						+'</td></tr>';
				}
				var html='<tbody>'+th+tbody+'</tbody>';
				$('#checkpoint-data').html(html);
				$('.focus').css({
					'display':'block'
				});
			}
		});
	}

});