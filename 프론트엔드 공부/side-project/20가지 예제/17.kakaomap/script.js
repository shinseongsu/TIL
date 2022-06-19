;(function () {
    'use strict'
  
    const shops = [
      {
        id: 1292273001,
        name: '매콤돈가스&칡불냉면 판교점',
        lat: 37.40189834738935,
        lng: 127.10624455094185,
      },
      {
        id: 1151112822,
        name: '탄탄면공방 판교테크노밸리점',
        lat: 37.40193038525563,
        lng: 127.11060980539878,
      },
      {
        id: 15775065,
        name: '파리바게뜨 판교테크노점',
        lat: 37.40133360873933,
        lng: 127.10801128231743,
      },
    ]
  
    const defaultPos = {
      lat: 37.4020589,
      lng: 127.1064401,
    }
  
    const get = (target) => {
      return document.querySelector(target)
    }
  
    const $map = get('#map')
    const geoLocationButton = get('.geolocation_button')
  
    const mapContainer = new kakao.maps.Map($map, {
      center: new kakao.maps.LatLng(defaultPos.lat, defaultPos.lng),
      level: 3,
    })
  
    const createMarkerImage = () => {
      let markerImageSrc = 'assets/marker.png'
      let imageSize = new kakao.maps.Size(30, 46)
      return new kakao.maps.MarkerImage(markerImageSrc, imageSize)
    }
  
    const createMarker = (lat, lng) => {
      const marker = new kakao.maps.Marker({
        map: mapContainer,
        position: new kakao.maps.LatLng(lat, lng),
        image: createMarkerImage(),
      })
      return marker
    }
  
    const createShopElement = () => {
      shops.map((shop) => {
        const { lat, lng } = shop
        const marker = createMarker(lat, lng)
        const infowindow = new kakao.maps.InfoWindow({
          content: `<div style="width:150px;text-align:center;padding:6px 2px;">
                    <a href="https://place.map.kakao.com/${shop.id}" target="_blank">${shop.name}</a>
                  </div>`,
        })
  
        infowindow.open(mapContainer, marker)
      })
    }
  
    const successGeolocation = (position) => {
      const { latitude, longitude } = position.coords
      mapContainer.setCenter(new kakao.maps.LatLng(latitude, longitude))
      const marker = createMarker(latitude, longitude)
      marker.setMap(mapContainer)
    }
  
    const errorGeolocation = (error) => {
      if (error.code == 1) {
        alert('위치 정보를 허용해주세요.')
      } else if (error.code == 2) {
        alert('사용할수 없는 위치 입니다.')
      } else {
        alert('오류가 발생했습니다.')
      }
    }
  
    const getLocation = () => {
      if ('geolocation' in navigator) {
        navigator.geolocation.getCurrentPosition(
          successGeolocation,
          errorGeolocation
        )
      } else {
        alert('지도 관련 api 를 불러올수 없습니다')
      }
    }
  
    const init = () => {
      geoLocationButton.addEventListener('click', () => {
        getLocation()
      })
      createShopElement()
    }
  
    init()
  })()
  