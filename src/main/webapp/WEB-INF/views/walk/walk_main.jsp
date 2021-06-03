<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Walk Main</title>
	</head>
	<body>
		<table>
			<tr>
				<td>
				
				</td>
			</tr>
			<tr>
				<td>
				<div align="center" id="map" style="width:100%; height:400px;"></div>
			<!-- 	<p>
				    <button onclick="selectOverlay('POLYLINE')">선</button>
				</p> -->
				
				<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1b5ecc9c7338c5ac5e6289af4a3977b2&libraries=drawing"></script>
				<script>
					var mapContainer = document.getElementById('map'),
						mapOptions = { center: new kakao.maps.LatLng(37.52738, 126.91646),
						level: 5
					};
			
					var map = new kakao.maps.Map(mapContainer, mapOptions);
					
					var polyline = new kakao.maps.Polyline({
						map: map, // 선을 표시할 지도 객체
						path:[	  // 선을 구성하는 좌표 배열
							new kakao.maps.LatLng(37.52968, 126.91166),
							new kakao.maps.LatLng(37.52954, 126.91501),
							new kakao.maps.LatLng(37.52738, 126.91646),
							new kakao.maps.LatLng(37.52594, 126.91755),
							new kakao.maps.LatLng(37.52399, 126.91764),
							new kakao.maps.LatLng(37.52413, 126.91249)
						],
						strokeWeight: 5,		 // 선의 두께
						strokeColor: '#FF0000',  // 선 색
						strokeOpacity: 0.9, 	 // 선 투명도
						strokeStyle: 'shortdash' // 선 스타일
					});
		
/* Drawing Manager
					var options = { // Drawing Manager를 생성할 때 사용할 옵션입니다
						    map: map, // Drawing Manager로 그리기 요소를 그릴 map 객체입니다
						    drawingMode: [ // drawing manager로 제공할 그리기 요소 모드입니다
						        kakao.maps.drawing.OverlayType.POLYLINE
						    ],
						    // 사용자에게 제공할 그리기 가이드 툴팁입니다
						    // 사용자에게 도형을 그릴때, 드래그할때, 수정할때 가이드 툴팁을 표시하도록 설정합니다
						    polylineOptions: { // 선 옵션입니다
						        draggable: true, // 그린 후 드래그가 가능하도록 설정합니다
						        removable: true, // 그린 후 삭제 할 수 있도록 x 버튼이 표시됩니다
						        editable: true, // 그린 후 수정할 수 있도록 설정합니다 
						        strokeColor: '#39f', // 선 색
						        hintStrokeStyle: 'dash', // 그리중 마우스를 따라다니는 보조선의 선 스타일
						        hintStrokeOpacity: 0.5  // 그리중 마우스를 따라다니는 보조선의 투명도
						    }
						   
						};
		
						// 위에 작성한 옵션으로 Drawing Manager를 생성합니다
						var manager = new kakao.maps.drawing.DrawingManager(options);
		
						// 버튼 클릭 시 호출되는 핸들러 입니다
						function selectOverlay(type) {
						    // 그리기 중이면 그리기를 취소합니다
						    manager.cancel();
		
						    // 클릭한 그리기 요소 타입을 선택합니다
						    manager.select(kakao.maps.drawing.OverlayType[type]);
						}
*/		
				</script>
				</td>
			</tr>
		</table>
	</body>
</html>