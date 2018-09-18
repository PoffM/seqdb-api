Examples
========

Add new Region:

.. code-block:: console

  curl -XPOST -H "Content-Type: application/vnd.api+json" \
  --data '{"data":{"type": "region", "attributes": {"name":"My Region", "description":"My Description", "symbol":"My Symbol"}}}' \
  http://localhost:8080/api/region